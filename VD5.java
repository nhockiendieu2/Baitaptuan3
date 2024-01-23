
package baitaptuan3;
public class VD5 {
    private final Object monitor = new Object();
    public void doi() throws InterruptedException
    {
        monitor.wait();
    }
    
    public void danhThuc()
    {
        synchronized (monitor) {
            monitor.notify(); // Danh Thuc
        }
    }
}
