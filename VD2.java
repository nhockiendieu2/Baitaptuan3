
package baitaptuan3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VD2 {
    private int count =0;
    private Lock lc = new ReentrantLock(); // Tao ham kiem soat
    public void demTang()
    {
        lc.lock(); // khoa lai
        try {
            count++; // Thuc hien dem
        } catch (Exception e) {
        }
        finally
        {
            lc.unlock(); // Dem xong can mo khoa
        }
    }
}
