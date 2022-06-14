public class Teemo_Attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if(timeSeries == null || duration == 0){
            return 0;
        }

        int totalTime = 0;
        for (int i = 0; i < timeSeries.length; i ++){
            if( i == timeSeries.length - 1){
                totalTime += duration;
            }else{
                if(timeSeries[i+1] <= (timeSeries[i]+duration-1) ){
                    totalTime = totalTime + (timeSeries[i+1] - timeSeries[i]);
                }else{
                    totalTime += duration;
                }
            }

        }

        return totalTime;

    }

    public static void main(String[] args) {
        int timeSeries[] = {1,2};
        int duration = 2;
        Teemo_Attacking a = new Teemo_Attacking();
        int result = a.findPoisonedDuration(timeSeries,duration);
        System.out.println(result);
    }

//    Official Answer
//    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        int ans = 0;
//        int expired = 0;
//        for (int i = 0; i < timeSeries.length; ++i) {
//            if (timeSeries[i] >= expired) {
//                ans += duration;
//            } else {
//                ans += timeSeries[i] + duration - expired;
//            }
//            expired = timeSeries[i] + duration;
//        }
//        return ans;
//    }
//    如果当前他正处于未中毒状态，则此时他的中毒持续时间应增加 duration，同时更新本次中毒结束时间 expired 等于 timeSeries[i] + duration；
//    如果当前他正处于中毒状态，由于中毒状态不可叠加，我们知道上次中毒后结束时间为 expired，本次中毒后结束时间为 timeSeries[i] + duration，因此本次中毒增加的持续中毒时间为 timeSeries[i]+duration−expired；
//    我们将每次中毒后增加的持续中毒时间相加即为总的持续中毒时间。


}
