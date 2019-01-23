package fracCalcOld;

import org.junit.Test;

// Checkpoint 3-only tests
public class FracCalcTestCheckpoint3
{
    @Test public void testCheckpoint3_AdditionSimple3() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "4_3/7", FracCalcOld.produceAnswer("1_1/7 + 3_2/7"));}
    @Test public void testCheckpoint3_AdditionWholeNumbers2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1", FracCalcOld.produceAnswer("2/3 + 1/3"));}
    @Test public void testCheckpoint3_AdditionWholeNumbers7() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1021778", FracCalcOld.produceAnswer("124543 + 897235"));}
    @Test public void testCheckpoint3_AdditionWithNegatives4() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "-1_1/4", FracCalcOld.produceAnswer("-3_3/4 + 2_2/4"));}
    @Test public void testCheckpoint3_AdditionImproperFractionsAndReductions2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1_1/20", FracCalcOld.produceAnswer("4/5 + 2/8"));}
    @Test public void testCheckpoint3_AdditionCombined4() { FracCalcTestALL.assertForEarlyCheckpoints(null, null, "62_11/19", FracCalcOld.produceAnswer("0 + 34_543/19"));}
    @Test public void testCheckpoint3_SubtractionSimple3() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "0", FracCalcOld.produceAnswer("4_1/2 - 4_1/2"));}
    @Test public void testCheckpoint3_SubtractionWithNegatives3() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "-1_1/4", FracCalcOld.produceAnswer("-3_3/4 - -2_2/4"));}
    @Test public void testCheckpoint3_SubtractionCombined2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "8_5/21", FracCalcOld.produceAnswer("-12_3/7 - -20_2/3"));}
    @Test public void testCheckpoint3_MultiplicationBasic1() {  FracCalcTestALL.assertForEarlyCheckpoints(null, null, "3", FracCalcOld.produceAnswer("1_1/2 * 2"));}
    @Test public void testCheckpoint3_MultiplicationBasic10() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "378/943", FracCalcOld.produceAnswer("27/41 * 14/23"));}
    @Test public void testCheckpoint3_MultiplicationBasic3() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "164268", FracCalcOld.produceAnswer("234 * 702"));}
    @Test public void testCheckpoint3_MultiplicationWithNegatives2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "-8", FracCalcOld.produceAnswer("-12/3 * 2/1"));}
    @Test public void testCheckpoint3_MultiplicationWithNegatives6() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "15_5/7", FracCalcOld.produceAnswer("-3_2/3 * -4_2/7"));}
    @Test public void testCheckpoint3_MultiplicationByZero2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "0", FracCalcOld.produceAnswer("0 * 0"));}
    @Test public void testCheckpoint3_MultiplicationByZero3() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "0", FracCalcOld.produceAnswer("0 * 9321"));}
    @Test public void testCheckpoint3_MultiplicationByZero4() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "0", FracCalcOld.produceAnswer("0 * -5902"));}
    @Test public void testCheckpoint3_MultiplicationCombined1() {   FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1065_115/168", FracCalcOld.produceAnswer("-32_75/16 * -27_43/21"));}
    @Test public void testCheckpoint3_MultiplicationCombined2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "-15_67/943", FracCalcOld.produceAnswer("1_27/41 * -3_140/23"));}
    @Test public void testCheckpoint3_DivisionBasic1() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "9/16", FracCalcOld.produceAnswer("3/4 / 4/3"));}
    @Test public void testCheckpoint3_DivisionBasic2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "2_1/4", FracCalcOld.produceAnswer("3/2 / 2/3"));}
    @Test public void testCheckpoint3_DivisionWithNegatives5() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "-2_6/7", FracCalcOld.produceAnswer("-20 / 7"));}
    @Test public void testCheckpoint3_DivisionWithNegatives6() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1_13/32", FracCalcOld.produceAnswer("-3_3/4 / -2_2/3"));}
    @Test public void testCheckpoint3_DivisionWithZero5() { FracCalcTestALL.assertForEarlyCheckpoints(null, null, "0", FracCalcOld.produceAnswer("0 / 46/27"));}
    @Test public void testCheckpoint3_DivisionWithZero6() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "0", FracCalcOld.produceAnswer("0/24 / 1/46"));}
    @Test public void testCheckpoint3_DivisionCombined2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "-2_2/3", FracCalcOld.produceAnswer("16/4 / -3/2"));}
    @Test public void testCheckpoint3_DivisionCombined3() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "6_661/5520", FracCalcOld.produceAnswer("-38_3/72 / -4_82/37"));}
}
