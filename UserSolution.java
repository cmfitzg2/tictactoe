public class UserSolution {
    public static int longest_flat(int[] array) {
        int num = 1;
        int comp = 0;
        for(int i = 0; i<array.length; i++)
        {
            if(array[i+1] == array[i])
               comp++;
            if(comp>num)
               num = comp;
        }
		return comp;
        
    }
}
