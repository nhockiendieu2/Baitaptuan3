
package baitaptuan3;
public class VD6 {
    private final Object monitor = new Object();
    private boolean coTien = false; // Kiem tra tien
    // Phuong thuc kiem tra tien
    public void kiemTien() throws InterruptedException{
        synchronized (monitor) {
            while(coTien){
                monitor.wait(); // Doi den khi co tien de tieu
            }
            
            // Mo phong qua trinh kiem tien :D
            System.out.println("Kiem Tien......");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Sau khi kie tien
            coTien = true;
            monitor.notify(); // Thong bao rang tien da san sang de tieu
        }
    
    }
    // Phuong thuc tieu tien
    public void tieuTien() throws InterruptedException{
        synchronized (monitor) {
            while(!coTien){
                monitor.wait(); // Doi den khi co tien de tieu
            }
            
            System.out.println("Tieu Tien.....");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            coTien = false; // Tieu het tien, dat lai la false
            monitor.notify(); // Thong bao rang da tieu xong tien
        }
    }
    
    public static void main(String[] args) {
        VD6 example = new VD6();
        // tAO va bat dau 1 luong de kiem tien
        Thread kiemTienThread = new Thread(()->{
            try {
                while(true)
                {
                    example.kiemTien();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Tao va bat dau 1 luong de tieu tien
        Thread tieuTienThread = new Thread(()->{
            try {
                while(true)
                {
                    example.tieuTien();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Chay cac luong
        kiemTienThread.start();
        tieuTienThread.start();
    }
}
