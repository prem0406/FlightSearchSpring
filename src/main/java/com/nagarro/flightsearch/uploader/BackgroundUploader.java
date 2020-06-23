/**
 * 
 */
package com.nagarro.flightsearch.uploader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nagarro.flightsearch.common.constant.Constant;
import com.nagarro.flightsearch.common.exception.FlightException;
import com.nagarro.flightsearch.common.exception.InvalidArgumentException;
import com.nagarro.flightsearch.importer.CSVImporter;
import com.nagarro.flightsearch.importer.FileImporter;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.service.api.FlightService;
import com.nagarro.flightsearch.util.FileUtil;
import com.nagarro.flightsearch.util.StringUtil;
import com.nagarro.flightsearch.validator.FlightValidator;

/**
 * The class {@link BackgroundUploader} scans in background for the new files of specified extensions. It scans files in
 * a specified directory for every specified time interval.
 * 
 * @author Prem Kumar
 * @since 1.0
 * 
 */
@Component
public class BackgroundUploader implements Runnable {

    // holds directory to scan
    private String directory;

    // holds the time interval for delay between search
    private int searchDelay;

    // holds the extension for the file
    private String fileExtension;

    // holds the condition scanning to run.If false,stops the scanning process
    private volatile boolean cancelled;

    /**
     * keeps track of the files that are already imported. As used HashSet thus it cannot not contains the duplicate
     * entry.
     */
    private Set<String> filesAlreadyImported = new HashSet<String>();

    // holds the service object that is used to insert the data from the importer
    private FlightService flightService;

    // log4j logger
    private static final Logger LOGGER = Logger.getLogger(BackgroundUploader.class);

    /**
     * Constructs a new ScanFile with the directory,file extension and time interval gap with the values specified in
     * the property file. If the property file contains invalid value than default values will be used respectily.
     * 
     * @throws InvalidArgumentException
     * 
     */
    public BackgroundUploader() {
        setDirectory(Constant.DEFAULT_DIRECTORY_TO_SCAN);
        setSearchDelay(Constant.DEFAULT_SEARCH_DELAY);
        setFileExtension(Constant.DEFAULT_FILE_EXTENSION);
    }

    /**
     * creates a new {@link BackgroundUploader} object with the specified service object. This service object should
     * contains an add method that will be used to insert flight data that is found during scanning.
     * 
     * <br>
     * <br>
     * The add() method must have the following declaration: <br>
     * void add(Flight flight)
     * 
     * @param service
     *            the service object
     * @see FlightService
     */
    public BackgroundUploader(FlightService service) {
        this.setFlightService(service);
    }

    /**
     * @return the directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * @param directory
     *            the directory to set for scanning
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * @return the delay between scanning the directory
     */
    public int getSearchDelay() {
        return searchDelay;
    }

    /**
     * @param searchDelay
     *            the delay between scanning the directory
     */
    public void setSearchDelay(int searchDelay) {
        this.searchDelay = searchDelay;
    }

    /**
     * @return the file extension of the file to scan
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * Sets the file extension to be searched while scanning
     * 
     * @param fileExtension
     *            the file extension to set
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * @return the flightService
     */
    public FlightService getFlightService() {
        return flightService;
    }

    /**
     * @param flightService
     *            the flightService to set
     */
    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Sets the cancel property to true,which further stops scanning.
     */
    public void cancel() {
        cancelled = true;
    }

    /**
     * Returns true if the call to cancel() is successful.
     * 
     * @return boolean if cancel() is called, otherwise false
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Starts scanning for the file(provided in the constructor) in background. And store the imported file in the
     * database
     * 
     * @throws IOException
     * 
     */
    public void startScanningInBackground() throws IOException {

        createDirectoryIfNotExists(getDirectory());

        Thread searchingForNewFileThread = new Thread(this, "SearchingForNewFileThread");
        searchingForNewFileThread.start();
    }

    private void createDirectoryIfNotExists(String directory) throws IOException {
        if (StringUtil.isStringValid(directory)) {
            FileUtil.createDirectory(directory);
        }
    }

    /**
     * @see java.lang.Runnable#run()
     */
    public void run() {
        String searchDirectory = null;
        String filePath = null;

        searchDirectory = getDirectory();
        while (!isCancelled()) {
            try {
                // is there a new file added to provided directory
                if (FileUtil.isNewFileFoundInDir(searchDirectory, filesAlreadyImported, getFileExtension())) {

//                    filePath = getAbsolutePath(FileUtil.getLastFileFound());
                    // if yes, then import data from file
//                    importFromFile(filePath);
                	importFromFile("C:\\FlightSearch\\flightscsv\\AirIndia.csv");
                	cancelled = true;
                }
                // sleeps for the provided search delay time
                Thread.sleep(getSearchDelay());
            } catch (InterruptedException e) {
                LOGGER.error("Interrupted Exception Occurred!!\n", e);
                System.out.println("Interruption in Importing!!\n Refer Error log for details.");
            } catch (FileNotFoundException e) {
                LOGGER.error("File " + getAbsolutePath(FileUtil.getLastFileFound()) + "not found!!\n", e);
            }
        }
    }

    /**
     * Imports the fields from the file found during scanning It appends the new fields(found in the file ) to the
     * Multimap that is specified in startScanningInBackground()
     * 
     * @param filePath
     * 
     * @throws FileNotFoundException
     */
    private void importFromFile(String filePath) throws FileNotFoundException {
        String delimiter = null;
        Flight newFlight;
        List<String[]> newFlightList = null;

        if (filePath == null) {
            LOGGER.info("\n\nNothing to import.Parameter 'filePath' is found null in importFromFile(). \n\n");
            return;
        }

        delimiter = Constant.DEFAULT_FILE_DELIMITER;
        newFlightList = new ArrayList<String[]>();

        // importing from csv
        FileImporter csvImporter = new CSVImporter(filePath, delimiter);
        newFlightList = csvImporter.extractFields();

        LOGGER.info("\nImporting from file " + filePath);
        LOGGER.info("New file contains " + newFlightList.size() + "rows.\n");

        // extracting each flight details from list that is returned by importer
        for (String[] newFlightArray : newFlightList) {
            newFlight = getFlightFromFields(newFlightArray);

            // add to data store
            getFlightService().add(newFlight);
        }
        LOGGER.info("Importing file " + filePath + " successful.\n");
    }

    private Flight getFlightFromFields(String[] newFlightArray) {
        Flight newFlight = null;

        if (newFlightArray != null) {
            try {
                // validating the flight details
                if (FlightValidator.isFlightDetailsValid(newFlightArray)) {
                    // create object of Flight from the flight details
                    newFlight = new Flight(newFlightArray);
                }
            } catch (InvalidArgumentException e) {
                LOGGER.error(
                        "Skipping an entry of csv file because of Invalid Argument!!!\n"
                                + Arrays.toString(newFlightArray) + "\n Detailed  Error: " + e.getMessage() + "\n", e);
            } catch (FlightException e) {
                LOGGER.error(
                        "Skipping an entry of csv file because of invalid field!!!\n" + Arrays.toString(newFlightArray),
                        e);
            }
        }
        return newFlight;
    }

    /**
     * Returns the absolute path for the file found during scanning
     * 
     * @param fileName
     *            name of the file for which absolute path is to return
     * @return absolutePath {@link String}
     */
    private String getAbsolutePath(String fileName) {
        String absolutePath = null;

        absolutePath = getDirectory() + "\\" + fileName;
        return absolutePath;
    }
}
