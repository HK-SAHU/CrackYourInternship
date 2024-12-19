class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        int sum=0;
        for(int i=0;i<boxTypes.length;i++){
            int numberOfBoxes= boxTypes[i][0];
            int units= boxTypes[i][1];
            int min= Math.min(numberOfBoxes, truckSize);
            truckSize-=min;
            sum+=min*units;
            if(truckSize==0) return sum;
        }
        return sum;
    }
}