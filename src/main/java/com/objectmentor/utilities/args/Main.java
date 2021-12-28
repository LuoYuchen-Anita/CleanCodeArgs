package com.objectmentor.utilities.args;

import com.objectmentor.utilities.args.Args;
import com.objectmentor.utilities.args.ArgsException;

public class Main {
    public static void main(String[] args) {
        try {
            String[] argsNew= {"0","9900","d://"};
            Args arg = new Args("l,p#,d*" , argsNew);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        }
        catch(ArgsException e){
            System.out.printf("Argument error:%s\n",e.errorMessage());
        }
    }

    static void executeApplication(boolean logging, int port, String directory){
        System.out.printf("is logging: %b, port number: %d, directory: %s", logging, port, directory);
    }
}
