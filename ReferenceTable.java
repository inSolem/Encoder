package com.linjie;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReferenceTable {

    protected String[] referenceTable = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                                        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
                                        "3", "4", "5", "6", "7", "8", "9", "(", ")", "*", "+", ",", "-", ".", "/"};

    protected int getReferenceIndex(String letter){
        return Arrays.asList(referenceTable).indexOf(letter);
    }

    private String getShiftReference(int shift, String letter){
        int shiftIndex = (getReferenceIndex(letter) + shift) % 44; //To cater to index overflow, 44 elements in total in referenceTable
        if(shiftIndex < 0){
            shiftIndex = 44 + shiftIndex; //To ensure the 43rd index element is not skipped
        }
        return referenceTable[shiftIndex];
    }

    private String encodeDecode(String text, boolean isEncode){
        char[] charArray = text.toCharArray();

        String firstLetter = String.valueOf(charArray[0]);

        int shift;

        if (isEncode){
            shift = -getReferenceIndex(firstLetter);
        }
        else {
            shift = getReferenceIndex(firstLetter);
        }

        String newText = "";
        for(int i = 1; i < charArray.length; i++){
            if(charArray[i] == ' '){
               newText += " ";
            }
            else {
                String shiftedLetter = getShiftReference(shift, String.valueOf(charArray[i]));
                newText += shiftedLetter;
            }
        }
        return newText;
    }

    public String decode(String encodedText){
        return encodeDecode(encodedText, false);
    }

    public String encode(String plainText){
        return encodeDecode(plainText, true);
    }
}
