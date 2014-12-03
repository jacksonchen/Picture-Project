/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
    /** Method to test zeroBlue */
    public static void testZeroBlue()
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical()
    {
        Picture caterpillar = new Picture("beach.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /** Method to test mirrorTemple */
    public static void testMirrorTemple()
    {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    /** Method to test the collage method */
    //     public static void testCollage()
    //     {
    //         Picture canvas = new Picture("640x480.jpg");
    //         canvas.createCollage();
    //         canvas.explore();
    //     }

    /** Method to test edgeDetection */
    public static void testEdgeDetection()
    {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    public static void testKeepOnlyBlue(){

        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }

    public static void testNegate(){

        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }

    public static void testGrayscale(){

        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.grayScale();
        beach.explore();
    }

    public static void testFixUnderwater(){

        Picture beach = new Picture("water.jpg");
        beach.explore();
        beach.fixUnderwater();
        beach.explore();
    }

    public static void testMirrorVerticalRightToLeft(){

        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.mirrorVerticalRightToLeft();
        beach.explore();
    }

    public static void testMirrorHorizontal()
    {
        Picture caterpillar = new Picture("beach.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorrizontal();
        caterpillar.explore();
    }

    public static void testMirrorHorizontalBotToTop(){
        Picture c = new Picture("beach.jpg");
        c.explore();
        c.mirrorHorrizontalBotToTop();
        c.explore();
    }

    public static void testMirrorDiagonal(){
        Picture c = new Picture("beach.jpg");
        c.explore();
        c.mirrorDiagonal();
        c.explore();
    }

    public static void testArms(){
        Picture c = new Picture("snowman.jpg");
        c.explore();
        c.mirrorArms();
        c.explore();
    }

    public static void testMirrorGull(){
        Picture c = new Picture("seagull.jpg");
        c.explore();
        c.mirrorGull();
        c.explore();
    }

    public static void testCopy(){

        Picture c = new Picture("640x480.jpg");
        c.explore();
        c.createMagic();
        c.explore();
    }
    public static void testMyCollage(){
        Picture c = new Picture("640x480.jpg");
        c.explore();
        c.myCollage();
        c.explore();
    }
    public static void testEdgeDetection2(){
        Picture c = new Picture("swan.jpg");
        Picture d = new Picture("swan.jpg");
        c.explore();
        c.edgeDetection2();
        d.edgeDetection(10);
        c.explore();
        d.explore();
    }

    /** Main method for testing.  Every class can have a main
     * method in Java */
    public static void main(String[] args)
    {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        //testZeroBlue();
        //testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
        //testNegate();
        //testGrayscale();
        //testFixUnderwater();
        //testMirrorVertical();
        //testMirrorVerticalRightToLeft();
        //testMirrorTemple();
        //testMirrorDiagonal();
        //testMirrorHorizontal();
        //testMirrorArms();
        //testMirrorGull();
        //testMirrorDiagonal();
        //testCollage();
        //testCopy();
        //testEdgeDetection();
        testEdgeDetection2();
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}