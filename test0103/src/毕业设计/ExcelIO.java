package 毕业设计;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//.csv文件其实就是以逗号隔开的txt文件

public class ExcelIO {
    public static void main(String[] args) {
        ExcelIO ins = new ExcelIO();
        //System.out.println(ins.fileRead("D://桌面杂项文件//毕业设计//数据//下一页//下一页 (2).csv",0).toString());
        //ins.fileWrite("D://桌面杂项文件//毕业设计//数据//特征值.csv");
        //double[] arr = {1,2,3,4,5};
        //ins.fileWrite("D://桌面杂项文件//毕业设计//数据//特征值.csv",arr);
        //D:\桌面杂项文件\毕业设计\数据\下一页\下一页 (20).csv
        ins.calculateFeature();
    }

    //计算特征值
    public void calculateFeature(){
        int dataSize = 100;
        String pathHead = "D://桌面杂项文件//毕业设计//数据//数据//未归一化的数据//";
        String[] dataTypeArr = {"上","下","左","右","顺时针","逆时针"};    //六种类型的原始数据，需要一次遍历完统一计算特征值，存储为一列数据使用
        double[] arr = new double[dataSize*6];
        //遍历六种类型的数据
        int start = 0;      //特征值在arr中的起始存储位置
        for(String dataType : dataTypeArr){
            //遍历每种数据的所有行
            for(int i=1;i<=dataSize;i++){
                String path = pathHead;
                path += dataType + "//预处理后的" + dataType + " (" + i + ").csv";
                double[] data = fileRead(path,2);       //使用加速度数据的那一列 x,y,z
                double result = MyMath.getMedianAbsoluteDeviation(data);        //统计哪种特征值
                arr[start + i - 1] = result;
            }
            start += dataSize;
        }
        fileWrite("D://桌面杂项文件//毕业设计//数据//数据//未归一化的数据//特征值.csv",arr);
    }

    //读指定path的文件,返回指定列column数据
    public double[] fileRead(String path,int column){
        List<Double> list = new ArrayList<>();      //暂存数据的list，原因是不知道有多少行数据
        double[] arr;       //返回值，将list转为arr
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));//换成你的文件名
            String line = null;
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                String last = item[column];//这就是你要的数据了
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                double value = Double.parseDouble(last);
                //System.out.println(last);     //逐行输出数据
                list.add(value);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        arr = new double[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

/*    //写指定path的文件，写到指定行row末尾,存储的值value
    //因为写文件主要用来存储特征值，每种特征值单独存储为一列
    public void fileWrite(String path,int row,double value){
        String updateValue = "";        //更新后的整行值
        //逐行遍历读取，找到要写的对应行
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));//换成你的文件名
            String line = null;
            for(int i=0;i<row-1;i++){
                reader.readLine();
            }
            updateValue = reader.readLine() + "," + value;
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File csv = new File(path); // CSV数据文件
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
            // 添加新的数据行
            bw.write("李四" + "," + "1988" + "," + "1992");
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            // File对象的创建过程中的异常捕获
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedWriter在关闭对象捕捉异常
            e.printStackTrace();
        }
    }*/

    //传入一整列数据，加在原表之后
    public void fileWrite(String path,double[] arr){
        //如果目录不存在创建目录
        File file = new File(path);
        File fileParent = file.getParentFile();
        if(!fileParent.exists()){
            fileParent.mkdir();
        }
        //更新数据,读原表
        List<String> list = new ArrayList<>();      //所有更新后的数据都被放入list中
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));//换成你的文件名

            String line = null;
            int i=0;
            while((line = reader.readLine()) != null){
                String updatedLine = line + "," + arr[i];
                list.add(updatedLine);
                i++;
            }
            reader.close();
        }catch (Exception e) {
            for(double temp : arr){
                list.add(temp + "");
            }
            e.printStackTrace();
        }
        //将更新后的数据写回原表
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false));
            for(String str : list){
                bw.write(str);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
