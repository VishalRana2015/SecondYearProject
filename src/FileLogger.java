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
                if(f.createNewFile())
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

    @Override
    public void log (String message) {
        /** TODO
         * create a new FileWriter in append mode
         * write the message to file
         * check the ExpectedOutput files
         * use try-with-resources/catch block
         */
    }
}
