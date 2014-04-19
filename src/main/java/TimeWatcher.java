import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: bogdan
 * Date: 19.04.14
 * Time: 12:03
 * To change this template use File | Settings | File Templates.
 */
public class TimeWatcher {

    public static void main(String []args){
        String dt = new SimpleDateFormat(("hh:mm aaa")).format(Calendar.getInstance().getTime());
        JOptionPane.showMessageDialog(null, "Текущее время: " + dt, "Время", JOptionPane.INFORMATION_MESSAGE);
    }
}
