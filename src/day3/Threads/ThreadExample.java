package day3.Threads;

/*
* THREAD (ASYNCRONOUS) : untuk ngejalanin beberapa tugas secara bersamaan di latar belakang
* tanpa mengganggu proses utamanya.
* */
class MyThread extends Thread {

    // overwrite mthod run dari Thread
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Thread.currentThread().getName() : buat ngambil nama thread yang sedang berjalan.
            System.out.println(Thread.currentThread().getName() + " value : " + i);

            try {
                // menghentikan thread selama 1 detik sebelum ke looping selanjutnya
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
                System.out.println("Error : Interupter thread");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start(); // thread pertama
        thread2.interrupt(); // interupsi thread pertama ketika lagi jalan buat nunjukin error
        thread2.start(); // thread kedua akan tetap jalan walau thread1 mati.
    }
}
