package com.guideal.guidclient.scripting.compiler.operations;

import com.guideal.guidclient.scripting.compiler.types.SFloatType;
import com.guideal.guidclient.scripting.compiler.types.SIntType;
import com.guideal.guidclient.scripting.compiler.types.SStringType;
import com.guideal.guidclient.scripting.compiler.types.SType;

public class ImplicitCast {
    public static UnaryOperation get(SType source, SType destination) {
        if (source == SIntType.instance && destination == SFloatType.instance) {
            return UnaryOperation.INT_TO_FLOAT;
        }
        if (source == SIntType.instance && destination == SStringType.instance) {
            return UnaryOperation.INT_TO_STRING;
        }
        return null;
    }
}