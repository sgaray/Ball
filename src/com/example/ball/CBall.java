package com.example.ball;

import java.util.Random;

public class CBall {
	//Member variables (properties about the object)
	public String[] mAnswers={
			"It is certain",
			"It is decidedly so",
			"All signs say Yes",
			"The stars are not aligned",
			"My reply is no",
			"It is doubtful",
			"Better not tell you now",
			"Concentrate and ask again",
			"Unable to answer now" };
	
	//Methods (abilities: things the object can do )
	public String getAnAnswer(){
	
		// The button was clicked, so update the answer label with an answer
		String answer= "";
		
		//Randomly select on of the three answers; Yes, No, or Maybe
		
		Random randomGenerator= new Random();//Construct a new random number
		int randomNumber = randomGenerator.nextInt(mAnswers.length);
		
		answer = mAnswers[randomNumber];
		
		return answer;
		
	}
}
