import java.util.List;

public class Day25 {
    public Day25(List<String> inputs) {
        long roomPublicKey = Integer.parseInt(inputs.get(0));
        long doorPublicKey = Integer.parseInt(inputs.get(1));
        long value = 1;
        long roomLoopSize = 0;
        while( value != roomPublicKey) {
            value = oneTransformation(value, 7);
            roomLoopSize++;
        }
        long encryptionKey = 1;
        for( long i = 0; i < roomLoopSize; i++) {
            encryptionKey = oneTransformation(encryptionKey, doorPublicKey);
        }
        System.out.println("The encryption key is " + encryptionKey);


    }

    private long oneTransformation(long value, long subjectNumber) {
        return (value*subjectNumber)%20201227;
    }

}
