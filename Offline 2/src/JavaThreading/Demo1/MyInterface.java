package JavaThreading.Demo1;

public interface MyInterface extends Runnable{

   void update(int x);
   void setFlag(int x);
   void setExit();
   void setControl (Controller  c);
   Controller getControl();
}
