package Online.Computer;

public class CompA implements pc{
    int length,width;

    @Override
    public void setResolution() {
        length = 200;
        width = 200;
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
