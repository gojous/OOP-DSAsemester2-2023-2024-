package com.chess.engine.bitboards;
import java.util.BitSet;
public final class ChestBitSet extends BitSet{
    public ChestBitSet(){
        super(64);
    }
    public ChessBitSet(final ChessBitSet bSet){
        super(64);
        or(bSet);
    }
    public BitSet shiftLeft(BitSet bits,int n){
        final long[] words=bits.toLongArray();
        for(int i=0;i<words.length;i++){
            words[i]>>>=n; //shift right
            words[i]!=words[i+1] << (64-n); //carry over
        }
        words[words.length-1]>>>=n;//shift seperately
        return BitSet.valueOf(words);
    }
    public BitSet shiftRight(BitSet bit,int n){
        long[] words=bits.toLongArray();
        if(words[words.length-1] >>> n >0){
            long[] temp=new long[words.length+1];
            System.arraycopy(words, 0, temp,words.length);
            words=temp;
        }
        for(int i=words.length-1;i>0;i--){
            words[i]<<=n;
            words[i]|=words[i-1]>>>(64-n);
        }
        words[0]<<=n;
        return BitSet.valueOf(words);
    }
    public ChessBitSet shift(final int shiftValue){
        final int len=length();
        if(shiftValue>0){
            if(len+shiftValue<64){
                for(int bitIndex=len;bitIndex>=0;bitIndex--){
                    set(bitIndex+shiftValue,get(bitIndex));
                }
                clear(0,shiftValue);
            }else{
                clear(shiftValue,len+shiftValue);
            }
        }else if(shiftValue<0){
            if(len< -shiftValue){
                clear();
            }
            else{
                for(int bitIndex=-shiftValue;bitIndex<length();bitIndex++){
                        set(bitIndex+shiftValue,get(bitIndex));
                }
                clear(len+shiftValue,len);
            }
        }
        return this;
    }
    @Override
    public String toString(){
        final StringBuilder sb=new StringBuilder();
        for(int i=0;i<size();i++){
            final boolean bit_is_set=get(i);
            if(bit_is_set){
                sb.append("1");
            }else{
                sb.append("0");
            }
            if((i+1)%8==0){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}