package matrix.io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by artur on 18.03.15.
 */
public abstract class IO_Abstract implements IO_Interface {

    File file = null;

    protected String generateName(String extent) {
        Calendar calendar = Calendar.getInstance();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/matrix_");
        stringBuilder.append(calendar.get(Calendar.YEAR));
        stringBuilder.append("-");

        if(calendar.get(Calendar.MONTH) <= 8) {
            stringBuilder.append("0");
        }
        stringBuilder.append(calendar.get(Calendar.MONTH)+1);
        stringBuilder.append("-");
        if(calendar.get(Calendar.DAY_OF_MONTH) <= 9) {
            stringBuilder.append("0");
        }
        stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH));
        stringBuilder.append("_");
        if(calendar.get(Calendar.HOUR) <= 9) {
            stringBuilder.append("0");
        }
        stringBuilder.append(calendar.get(Calendar.HOUR));
        stringBuilder.append("-");
        if(calendar.get(Calendar.MINUTE) <= 9) {
            stringBuilder.append("0");
        }
        stringBuilder.append(calendar.get(Calendar.MINUTE));
        stringBuilder.append("-");
        if(calendar.get(Calendar.SECOND) <= 9) {
            stringBuilder.append("0");
        }
        stringBuilder.append(calendar.get(Calendar.SECOND));
        stringBuilder.append(".");
        stringBuilder.append(extent);

        return stringBuilder.toString();
    }

    protected void checkPath(String path) throws IOException {
        file = new File(path);
        if(file.exists()) {

        } else {
            //file.createNewFile();
            if(file.mkdirs()) {

            } else {
                throw new IOException();
            }
        }


    }

}
