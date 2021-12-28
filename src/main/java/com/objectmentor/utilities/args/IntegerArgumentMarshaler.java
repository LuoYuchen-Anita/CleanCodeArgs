package com.objectmentor.utilities.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.objectmentor.utilities.args.ArgsException.ErrorCode.*;

public class IntegerArgumentMarshaler implements ArgumentMarshaler{
    private int intValue = 0;

    public void set(Iterator<String> currentArgument) throws ArgsException{
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        }catch (NoSuchElementException e){
            throw new ArgsException(MISSING_INTEGER);
        }catch (NumberFormatException e){
            throw new ArgsException(INVALID_INTEGER,parameter);
        }
    }

    public static int getValue(ArgumentMarshaler am){
        if (am != null && am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).intValue;
        else
            return 0;
    }
}
