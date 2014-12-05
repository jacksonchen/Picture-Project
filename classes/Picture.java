import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(0);
                pixelObj.setRed(0);
            }
        }
    }

    public void negate(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int red = 255 - pixelObj.getRed();
                int green = 255 -pixelObj.getGreen();
                int blue = 255-pixelObj.getBlue();
                pixelObj.setRed(red);
                pixelObj.setGreen(green);
                pixelObj.setBlue(blue);
            }
        }
    }

    public void grayScale(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int value = (pixelObj.getBlue()+pixelObj.getGreen()+pixelObj.getRed())/3;
                pixelObj.setGreen(value);
                pixelObj.setBlue(value);
                pixelObj.setRed(value);
            }
        }
    }

    public void fixUnderwater(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int red = pixelObj.getRed();
                int blue = pixelObj.getBlue();
                int green = pixelObj.getGreen();
                int diffromblue = Math.abs(blue-(red+green));
                //if(blue>(Math.abs(green+red-blue))){
                pixelObj.setBlue(blue-diffromblue);
                pixelObj.setGreen(green+diffromblue);
                pixelObj.setRed(red+diffromblue);
                //}
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    public void mirrorHorrizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        } 
    }

    public void mirrorHorrizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        } 
    }

    public void mirrorDiagonal(){
        Pixel[][] pixels = this.getPixels2D();

        Pixel one = null;
        Pixel two = null;

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {

                try{
                    one = pixels[row][col];
                    two = pixels[col][row];
                    one.setColor(two.getColor());
                }catch(Exception e){

                }
            }
        } 
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                count++;
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        System.out.println(count);
    }

    public void mirrorArms()
    {
        int top = 190;
        int bot = 225;
        int right = 96;
        int left = 311;

        Pixel[][] pixels = this.getPixels2D();
        Pixel lookingatPixel = null;
        Pixel copyingPixel = null;
        int height = pixels.length;
        for (int row = top; row < bot; row++)
        {
            for (int col = right; col < left; col++)
            {
                if(col < 171|| col >  233){
                    lookingatPixel = pixels[row][col];
                    copyingPixel = pixels[row - 2*(row-top)][col];
                    lookingatPixel.setColor(copyingPixel.getColor());
                }
            }
        } 
    }

    public void mirrorGull()
    {
        int top = 229;
        int bot = 330;
        int right = 347;
        int left = 225;

        Pixel[][] pixels = this.getPixels2D();
        Pixel lookingatPixel = null;
        Pixel copyingPixel = null;

        for (int row = top; row < bot; row++)
        {
            for (int col = left; col < right; col++)
            {
                lookingatPixel = pixels[row][col];
                copyingPixel = pixels[row][col-120];
                copyingPixel.setColor(lookingatPixel.getColor());
            }
        } 
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    public void copy(Picture fromPic, 
    int toRow, int toCol, int fromRowStart, int fromRowEnd, int fromColStart, int fromColEnd)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for(int toPixelRow = toRow, fromPixelRow = fromRowStart;
        fromPixelRow < fromRowEnd;
        toPixelRow++, fromPixelRow++){
            for(int toPixelCol = toCol, fromPixelCol = fromColStart;
            fromPixelCol < fromColEnd;
            toPixelCol++, fromPixelCol++){
                try{
                    fromPixel = fromPixels[fromPixelRow][fromPixelCol];
                    toPixel = toPixels[toPixelRow][toPixelCol];
                    toPixel.setColor(fromPixel.getColor());
                }catch(Exception e){
                    toPixelCol+=1000;
                    fromPixelCol+=1000;
                }
            }
        }
    }

    public void copy(Picture fromPic, 
    int toRow, int toCol, int fromRowStart, int fromRowEnd, int fromColStart, int fromColEnd, int effect)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        switch(effect){
            case 0: break;
            case 1: fromPic.zeroBlue();    break;
            case 2: fromPic.keepOnlyBlue(); break;
            case 3: fromPic.negate(); break;
            case 4: fromPic.grayScale(); break;
            case 5: fromPic.fixUnderwater(); break;

        }
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for(int toPixelRow = toRow, fromPixelRow = fromRowStart;
        fromPixelRow < fromRowEnd;
        toPixelRow++, fromPixelRow++){
            for(int toPixelCol = toCol, fromPixelCol = fromColStart;
            fromPixelCol < fromColEnd;
            toPixelCol++, fromPixelCol++){
                try{
                    fromPixel = fromPixels[fromPixelRow][fromPixelCol];
                    toPixel = toPixels[toPixelRow][toPixelCol];
                    toPixel.setColor(fromPixel.getColor());
                }catch(Exception e){
                    toPixelCol+=1000;
                    fromPixelCol+=1000;
                }
            }
        }
    }

    public void createMagic(){
        Picture a = new Picture("beach.jpg");
        Picture b = new Picture("seagull.jpg");

        this.copy(a,0,0,0,479,0,639);
        this.copy(b,100,100, 229, 330, 225, 347);

    }

    public void myCollage(){
        Random k = new Random();

        Pixel[][] collage = this.getPixels2D();

        Picture a = new Picture("beach.jpg");
        Picture b = new Picture("seagull.jpg");
        Picture c = new Picture("snowman.jpg");
        Picture[] pics = {a,b,c};
        int thisheight = collage.length;
        int thislength = collage[0].length;
        int firsty = 0;
        for(int y = 0; y<thisheight;y++){
            for(int x = 0; x<thislength;x++){
                int whichpic = k.nextInt(2);
                int effect = k.nextInt(5);
                int xadd = k.nextInt(100);
                if(xadd>thislength){
                    xadd=thislength-x;
                }
                int yadd = k.nextInt(100);
                if(yadd>thisheight){
                    yadd=thisheight-y;
                }
                int piccstart = k.nextInt(539);
                int piccend= piccstart+yadd;
                int picrstart = k.nextInt(379);
                int picrend=picrstart+xadd;
                this.copy(pics[whichpic],y+yadd,x+xadd,picrstart,picrend,piccstart,piccend,effect);
                firsty=yadd;
                x+=xadd;
            }
            y+=firsty;
        }

    }
    /** Method to create a collage of several pictures */
    //     public void createCollage()
    //     {
    //         Picture flower1 = new Picture("flower1.jpg");
    //         Picture flower2 = new Picture("flower2.jpg");
    //         this.copy(flower1,0,0);
    //         this.copy(flower2,100,0);
    //         this.copy(flower1,200,0);
    //         Picture flowerNoBlue = new Picture(flower2);
    //         flowerNoBlue.zeroBlue();
    //         this.copy(flowerNoBlue,300,0);
    //         this.copy(flower1,400,0); 
    //         this.copy(flower2,100,0);
    //         this.copy(flower1,200,0);
    //         Picture flowerNoBlue = new Picture(flower2);
    // 
    //         this.copy(flowerNoBlue,300,0);
    //         this.copy(flower1,400,0);
    //         this.copy(flower2,500,0);
    //         this.mirrorVertical();
    //         this.write("collage.jpg");
    //     }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel curPixel = null;
        Pixel rightPixel = null;

        Pixel botPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        Color botColor = null;
        for (int row = 0; row < pixels.length-1; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                curPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                botPixel = pixels[row+1][col];
                botColor = botPixel.getColor();
                rightColor = rightPixel.getColor();
                if (curPixel.colorDistance(rightColor) > 
                edgeDist)
                    curPixel.setColor(Color.BLACK);
                else if(curPixel.colorDistance(botColor) > edgeDist){
                    curPixel.setColor(Color.BLACK);
                }else{
                    curPixel.setColor(Color.WHITE);
                }
            }
        }
    }

    public void edgeDetection2()
    {
        Pixel curPixel = null;
        Pixel rightPixel = null;
        Pixel leftPixel = null;
        Pixel topPixel = null;
        Pixel botPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] pixelsOrg= this.getPixels2D();

        double averageDif = 0;
        int totalpixs = 0;

        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                totalpixs++;
                averageDif+=pixelObj.getAverage();
            }
        }
        int edgeDist = ((int)averageDif)/totalpixs;

        //System.out.println(totalpixs+" "+averageDif+" "+edgeDist);
        for (int row = 1; row < pixels.length-1; row++)
        {
            for (int col = 1; 
            col < pixels[0].length-1; col++)
            {
                int pointave = 0;
                try{
                    pointave = 0;
                    for(int i = -10; i < 10; i++){
                        for(int k = -10; k < 10; k++){
                            pointave+=(int)pixels[i+row][k+col].getAverage();
                        }
                    }
                    
                    pointave=(int)pointave/(10*(20*20));
                }catch(Exception e){
                }
                
                if(pointave > edgeDist){
                    pointave=edgeDist;
                }
                curPixel = pixels[row][col];
                rightPixel = pixelsOrg[row][col+1];
                botPixel = pixelsOrg[row+1][col];

                
                if(//curPixel.colorDistance(leftPixel.getColor())>5||
                curPixel.colorDistance(rightPixel.getColor())>pointave||
                    //curPixel.colorDistance(topPixel.getColor())>5||
                curPixel.colorDistance(botPixel.getColor())>pointave){

                    curPixel.setColor(Color.BLACK);  

                }else{
                    curPixel.setColor(Color.WHITE);
                }
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
