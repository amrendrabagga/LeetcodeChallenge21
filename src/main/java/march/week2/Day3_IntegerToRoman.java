package march.week2;

public class Day3_IntegerToRoman {
    public String intToRoman(int num) {
        String units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hundres[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String thousands[] = {"", "M", "MM", "MMM"};

        return thousands[num / 1000] +
                hundres[(num/100) % 10] +
                tens[(num/10) % 10] +
                units[num%10];
    }
}
