
/**
 * Write a description of acc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//编写具有一个String参数dna的方法cgRatio，
//并返回dna中C和G的比值作为DNA整个链的一部分。
//例如，如果字符串为“ ATGCCATAG”，则cgRatio将返回4/9
//或.4444444。提示：9/2使用整数除法，因为您将整数除以整数，
//因此Java认为您希望结果为整数。如果希望结果为十进制数，
//请确保将整数之一转换为十进制数，以将其转换为十进制数。
//例如，Java将（float）9/2解释为9.0 / 2，
//如果其中一个数字是十进制数，
//则Java假定您希望结果是一个十进制数。
//因此（float）9/2为4.5。
import edu.duke.*;
public class acc {
    public float cgRatio(String dna){
        int cursor = 0;
        int count = 0;
        while((cursor + 1) <= dna.length()){
            String tempStr = dna.substring(cursor,cursor+1);
            if(tempStr.equals("C")){
            count++;
            cursor++;
            }
            else{
            cursor++;
            }
        }
        int cursor1 = 0;
        int count1 = 0;
        while((cursor1 + 1) <= dna.length()){
            String tempStr1 = dna.substring(cursor1,cursor1+1);
            if(tempStr1.equals("G")){
            count1++;
            cursor1++;
            }
            else{
            cursor1++;
            }
        }
        return (float)count/(float)count1;
    }
    public void test(){
        float a = cgRatio("ACCGGG");
        System.out.println(a);
    }
    
    public void processGenes(StorageResource sr){
        int count = 0; // 记录所有大于60个的字符串数量
        int count1 = 0; //记录所有cg比例大于0.35的数量
        int oldLength = 0;
        for (String item:sr.data()){
            if (item.length() > 60){
                System.out.println(item);
                count++;
            }
            if (cgRatio(item)>0.35){
                System.out.println(item);
                count1++;
            }
            if (item.length()>oldLength){
                oldLength = item.length();
            }
        }
        System.out.println("the number of" + 
                "string longer than 60 is" + count);
        System.out.println("the number of" + 
                "cg ratio larger than 0.35 is" + count1);
        System.out.println("The longest length is" +oldLength);     
    }
    public void testProcessGenes(){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        System.out.println(dna);
    }
}

