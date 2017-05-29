package cardlayout;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.SSLException;
public class ran {
	TimerTask task;
	Timer timer;
  public ran(Client clinet  ) {
     task = new TimerTask() {
      @Override
      public void run() {
        // task to run goes here
    	  Random random=new Random();
    	  String high=String.format("%03d", (random.nextInt(160)+50)%210);
    	  String low=String.format("%03d", (random.nextInt(80)+20)%100);
       String heart=String.format("%03d", (random.nextInt(50)+50));
       SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String time=df.format(new Date());
       clinet.send(high+" "+low+" "+heart+" "+time);
      }
    };
     timer = new Timer();
    long delay = 0;
    long intevalPeriod = 2 * 1000;
    // schedules the task to be run in an interval
    timer.scheduleAtFixedRate(task, delay,
                                intevalPeriod);
  } // end of main
  public void stop() {
	timer.cancel();
}
  public static void main(String args[]) throws IOException, InterruptedException {
	 Client client= new Client();
	 client.start("localhost", 8001);
	ran r=new ran(client);
	Thread.sleep(10*1000);
r.stop();
}
}