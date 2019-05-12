package synthesizer;

import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdDraw;


public class GuitarHeroLite {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        double[] fre= new double[37];
        GuitarString[] notes = new GuitarString[37];
        for(int i = 0; i< keyboard.length(); i++) {
            fre[i] = 1200.0 * Math.pow(2, (i - 24) / 12.0);
            notes[i] = new synthesizer.GuitarString(fre[i]);
        }

        /* create two guitar strings, for concert A and C */

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if(keyboard.indexOf(key) >= 0) {
                    int freIndex = keyboard.indexOf(key);
                    notes[freIndex].pluck();
                }

            }

            /* compute the superposition of samples */
            double sample = 0;
            for(int i = 0; i < keyboard.length(); i++){
                sample = sample + notes[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for(int i = 0; i < keyboard.length(); i++){
                notes[i].tic();
            }
        }
    }
}