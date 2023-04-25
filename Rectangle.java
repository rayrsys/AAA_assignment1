import java.util.ArrayList;


public class Rectangle{
    public int xb;
    public int yb;
    public int xt;
    public int yt;
    public int length;
    // private int numadjacent=0;

    public ArrayList<Rectangle> rectArray = new ArrayList<Rectangle>();

public Rectangle(int xb, int yb, int xt, int yt) {
    this.xb = xb;
    this.yb = yb;
    this.xt = xt;
    this.yt = yt; 
}

public void adder(Rectangle obj){
    rectArray.add(obj);
}


public void printRectangles() {
    for (int j = 0; j < rectArray.size(); j++) {
        System.out.println("xb is :"+rectArray.get(j).xb+"yb is :"+rectArray.get(j).yb+"xt is :"+rectArray.get(j).xt+"yt is :"+rectArray.get(j).yt);
        System.out.println(rectArray.get(j).rectArray.size());    
    }
}

public int getNumAdjacent() {
    return rectArray.size();
}

public void check(ArrayList<Rectangle> currentarray,int i){
        for(int j = i+1; j < currentarray.size(); j++){
            // compare x and y values
            if(currentarray.get(j).xb == xt+1){
                // check if the rectangles touch
                if(currentarray.get(j).yb >= yb && currentarray.get(j).yb <= yt || currentarray.get(j).yt >= yb && currentarray.get(j).yt <= yt){
                    // add the rectangle to the adjacent array
                    adder(currentarray.get(j));
                    System.out.println("i did get here");
                }
            }
        }
    
}


}