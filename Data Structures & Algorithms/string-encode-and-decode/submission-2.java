class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append('#');
        List<Integer> sizes = new ArrayList<>();

        for(String str:strs) {
            int len = str.length();
            sizes.add(len);
            sb.append(len);
            sb.append(',');
            sb2.append(str);
        }
        sb.append(sb2);

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        int i=0;
        while(str.charAt(i)!='#') {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i)!=',') {
                sb.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(sb.toString()));
            i++;
        }
        i++;
        for(int s:sizes) {
            list.add(str.substring(i,i+s));
            i+=s;
        }
        return list;

     

    }
}
