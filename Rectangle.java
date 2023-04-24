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

public void add(Rectangle obj){
    rectArray.add(obj);
}


public void printRectangles() {
    for (Rectangle rec : rectArray) {
        System.out.println("xb is :"+rec.xb+"yb is :"+rec.yb+"xt is :"+rec.xt+"yt is :"+rec.yt);
        System.out.println(rec.rectArray.size());    
    }
}

public int getNumAdjacent() {
    return rectArray.size();
}

public void check(ArrayList<Rectangle> currentarray){
    for(int i = 0; i < currentarray.size(); i++){
        for(int j = i+1; j < currentarray.size(); j++){
            // compare x and y values
            if(currentarray.get(j).xb == currentarray.get(i).xt+1){
                // check if the rectangles touch
                if(currentarray.get(j).yb >= currentarray.get(i).yb && currentarray.get(j).yb <= currentarray.get(i).yt || currentarray.get(j).yt >= currentarray.get(i).yb && currentarray.get(j).yt <= currentarray.get(i).yt){
                    // add the rectangle to the adjacent array
                    currentarray.get(i).add(currentarray.get(j));
                }
            }
        }
    }
}


}
