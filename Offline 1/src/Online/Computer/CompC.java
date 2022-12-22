package Online.Computer;

public class CompC implements pc{
    int length,width;

    @Override
    public void setResolution() {
        length = 550;
        width = 430;
    }

    @Override
    public void printResolution() {
        System.out.println("the resolution is " + length + "X" + width);
    }
    @Override
    public boolean checkResolution(int x, int y) {
        if(x<= length && y <= width){
            return true;
        }
        else return false;
    }
}
