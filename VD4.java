
package baitaptuan3;

public class VD4 {
    private final Object lc = new Object(); // Doi tuong khoa
    
    public synchronized void pt1(){
        // phuong thuc dong bo hoa
    }
    
    public synchronized void pt2(){
        // phuong thuc dong bo hoa
        synchronized (lc) {
            //Giu khoa
        }
    }
    
    public static void main(String[] args) {
        Thread th = new Thread(()->{
            // code
        });
        th.start();
        try {
            // Phuong thuc 1 la tien trinh treo
        } catch (Exception e) {
        }
    }
}
