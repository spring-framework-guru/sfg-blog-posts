package guru.springframework.optionaldemos;

public class NPEExample {

    static String convert(String[] strArr, int index){
        if(strArr[index]!=null)
           return strArr[index].toUpperCase();
        else
            return "Please provide valid input";
    }
    public static void main(String[] args) {
        String[] strArr= new String[5];
        String convertedValue= convert(strArr,3);
        System.out.println(convertedValue);
    }
}