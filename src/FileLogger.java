import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private static final String FILE_LOGGER_NAME =  "StudentFileOutput.txt";

    static
    {

        /** TODO
         * create a new File object for FILE_LOGGER_NAME
         * if the file already exists, delete it first
         * use try/catch block
         */

        try
        {
            File f = new File(FILE_LOGGER_NAME);
            if(f.exists())
            {
                f.delete();
            }
            else
            {
                File f1 = new File(FILE_LOGGER_NAME);
                if(f1.createNewFile())
                {
                    System.out.println("File is created!!");
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("File Not Created, Something went wrong ");
            System.out.println(e);
            e.printStackTrace();
        }


    }
    FileWriter fw ;
    private static FileLogger fileLogger;
    public static FileLogger getFileLogger(){
        if ( fileLogger == null){
            fileLogger = new FileLogger();
        }
        return fileLogger;
    }

    private FileLogger( ){
        try{
            fw = new FileWriter(new File(FILE_LOGGER_NAME));
        }
        catch ( IOException e){
            System.out.println("Something went wrong while opening file " + FILE_LOGGER_NAME);
            System.out.println(e);
        }
    }
    @Override
    public void log (String message) {

        try
        {
            this.fw.append(message);
            this.fw.append("\n");
            this.fw.flush();
        }
        catch(Exception e)
        {
            System.out.println("Exception Thrown!!");
            e.printStackTrace();
        }

        /** TODO
         * create a new FileWriter in append mode
         * write the message to file
         * check the ExpectedOutput files
         * use try-with-resources/catch block
         */
    }
}
