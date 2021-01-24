package 毕业设计;

import java.util.Arrays;

public class DataProcessing {
    public static void main(String[] args) {
        /*ExcelIO excelIO = new ExcelIO();
        DataProcessing dataProcessing = new DataProcessing();
        String readPath = "D://桌面杂项文件//毕业设计//数据//处理之后的数据//滑动均值滤波后的播放 (1).csv";
        String writePath = "D://桌面杂项文件//毕业设计//数据//处理之后的数据//测试创建目录//归一化后的播放 (1).csv";
        double[] originData,processedData;
        originData = excelIO.fileRead(readPath,1);      //读原始数据
        processedData = dataProcessing.handleJumpPoint(originData);     //去除跳点
        excelIO.fileWrite(writePath,processedData);     //写预处理好的数据*/
        DataProcessing dataProcessing = new DataProcessing();
        double[] label = dataProcessing.addlable(6,100);
        ExcelIO excelIO = new ExcelIO();
        excelIO.fileWrite("D://桌面杂项文件//毕业设计//数据//数据//未归一化的数据//特征值.csv",label);
    }

    public void preProcess(){
        ExcelIO excelIO = new ExcelIO();
        String readPathHead = "D://桌面杂项文件//毕业设计//数据//数据//";
        String writePathHead = "D://桌面杂项文件//毕业设计//数据//数据//未归一化的数据//";
        double[] originData,processedData;
        String[] dataType = {"上","下","左","右","顺时针","逆时针"};
        int fileSize = 100;
        for(String type : dataType){
            for(int t=1;t<=fileSize;t++){
                String readPath = readPathHead + type + "//" + type + " (" + t + ").csv";
                String writePath = writePathHead + type + "//预处理后的" + type + " (" + t + ").csv";
                for(int i=0;i<3;i++){       //对数据的每一列进行处理
                    originData = excelIO.fileRead(readPath,i);      //读原始数据
                    processedData = handleJumpPoint(originData);     //去除跳点
                    processedData = movingAverageFilter(processedData,5);        //滤波
                    //processedData = normalization(processedData);        //归一化
                    excelIO.fileWrite(writePath,processedData);     //写预处理好的数据
                }
            }
        }
    }

    public double[] addlable(int dataLableKind,int dataSize){
        double[] arr = new double[dataLableKind * dataSize];
        int start = 0;
        for(int i=1;i<=dataLableKind;i++){
            for(int j=0;j<100;j++){
                arr[start + j] = i;
            }
            start += 100;
        }
        return arr;
    }

    //处理跳点
    public double[] handleJumpPoint(double[] data){
        int len = data.length;
        double[] res = new double[len];
        double front,next;      //front = A(t) - A(t-1);    next = A(t+1) - A(t)
        res[0] = data[0];
        res[len-1] = data[len-1];
        for(int i=1;i<len-1;i++){
            front = data[i] - data[i-1];
            next = data[i+1] - data[i];
            if(front * next < 0 && Math.abs(front) > 3 && Math.abs(next) > 3){
                res[i] = (res[i-1] + data[i+1]) / 2;
            }else{
                res[i] = data[i];
            }
        }
        return res;
    }

    /**
     * 滑动均值滤波
     * @param data  原始数据
     * @param windowSize 调用时需指定滑动窗口的大小
     * */
    public double[] movingAverageFilter(double[] data,int windowSize){
        int len = data.length;
        double[] res = new double[len];
        double windowSum = 0;       //滑动窗口内数据的总和
        for(int i=0;i<windowSize;i++){
            windowSum += data[i];
        }
        for(int i=0;i<windowSize/2;i++){
            res[i] = data[i];
        }
        for(int i=len-windowSize/2;i<len;i++){
            res[i] = data[i];
        }
        res[windowSize/2] = windowSum/windowSize;
        int left = 1;       //滑动窗口左端
        int right = windowSize;     //右端
        for(int i = windowSize / 2 + 1;i < len-windowSize / 2;i++){
            double variation = data[right] - data[left - 1];
            windowSum += variation;
            res[i] = windowSum/windowSize;
            left++;
            right++;
        }
        return res;
    }

    /**
     * 中值滤波
     * @param data  原始数据
     * @param windowSize 调用时需指定滑动窗口的大小
     * */
    public double[] medianFilter(double[] data,int windowSize){
        int len = data.length;
        double[] res = new double[len];
        double[] window = new double[windowSize];
        for(int i=0;i<windowSize/2;i++){
            res[i] = data[i];
        }
        for(int i=len-windowSize/2;i<len;i++){
            res[i] = data[i];
        }
        int left = 0;       //滑动窗口左端
        int right = windowSize-1;     //右端
        int curr = 0;       //window当前指针
        for(int i=windowSize/2;i<len-windowSize/2;i++){
            //先更新窗口内的数据
            curr = 0;
            for(int j = left;j<=right;j++){
                window[curr] = data[j];
                curr++;
            }
            Arrays.sort(window);
            res[i] = window[windowSize/2];
            left++;
            right++;
        }
        return res;
    }

    /**
     * 将y轴数据向上平移10，z轴数据向上平移20
     * 用以区分出x，y，z轴数据
     * */
    public double[] showDifference(double[] data,int gap){
        int len = data.length;
        double[] res = new double[len];
        for(int i=0;i<len;i++){
            res[i] = data[i] + gap;
        }
        return res;
    }

    /**
     * 归一化至（-1，1）区间
     * */
    public double[] normalization(double[] data){
        double[] res = new double[data.length];
        double mean = MyMath.getMean(data);
        double max = MyMath.getMax(data);
        double min = MyMath.getMin(data);
        for(int i=0;i<data.length;i++){
            res[i] = (data[i] - mean)/(max - min);
        }
        return res;
    }
}
