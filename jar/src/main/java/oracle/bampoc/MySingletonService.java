package oracle.bampoc;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import weblogic.cluster.singleton.SingletonService;

public class MySingletonService implements SingletonService {

   Timer timer = new Timer(true);

   @Override
   public void activate() {
          
      System.out.println("======================================");
      System.out.println("MySingletonServiceClass is activate");
      System.out.println("======================================");


      TimerTask timerTask = new MyTimerTask();
      // running timer task as daemon thread
      timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
      System.out.println("TimerTask started");
      // cancel after sometime
      // for testing purpose I put here SOP
   }

   @Override
   public void deactivate() {
      System.out.println("*************************************");
      System.out.println("MySingletonServiceClass is deactivate");
      System.out.println("*************************************");

      timer.cancel();
      System.out.println("TimerTask is canceled");

      // for testing purpose I put here SOP
   }
}