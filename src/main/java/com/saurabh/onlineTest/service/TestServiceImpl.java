package com.saurabh.onlineTest.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.ClientTransactionManager;

import com.saurabh.onlineTest.contract.NewOnlineTest;
import com.saurabh.onlineTest.entity.Question;

@Service
public class TestServiceImpl implements TestService {

	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	private static final String ADDRESS = "0xe8fbbddf73c128e25f824ec6af15cb15c237fe58";
	// considering that smart contract is already deployed
	private static final String CONTRACT_ADDRESS = "0x96CE6376d15A911F58A68aF459F061570464b141";
	private Parity web3j = Parity.build(new HttpService());
	// considering that admin account is unlocked forever
	private ClientTransactionManager txManager = new ClientTransactionManager(web3j, ADDRESS);
	private TransactionReceipt receipt = null;
	private static int counter = 0;

	@Override
	public Question showQuestion() {
		try {
			log.info("Inside showQuestion()===>Connected to Ethereum client version: "
					+ web3j.web3ClientVersion().send().getWeb3ClientVersion());
			NewOnlineTest onlineTest = NewOnlineTest.load(CONTRACT_ADDRESS, web3j, txManager, BigInteger.valueOf(10000),
					BigInteger.valueOf(4500000));
			int questCounter = onlineTest.questCounter().sendAsync().get().intValue();
			if (counter <= questCounter) {
				Tuple3<BigInteger, String, BigInteger> questTuple = onlineTest.questions(BigInteger.valueOf(counter))
						.sendAsync().get();
				String option1 = onlineTest.getOptionList(BigInteger.valueOf(counter), BigInteger.valueOf(1))
						.sendAsync().get();
				String option2 = onlineTest.getOptionList(BigInteger.valueOf(counter), BigInteger.valueOf(2))
						.sendAsync().get();
				String option3 = onlineTest.getOptionList(BigInteger.valueOf(counter), BigInteger.valueOf(3))
						.sendAsync().get();
				String option4 = onlineTest.getOptionList(BigInteger.valueOf(counter), BigInteger.valueOf(4))
						.sendAsync().get();
				Question question = new Question(questTuple.getValue1().intValue(), questTuple.getValue2(),
						questTuple.getValue3().intValue(), option1, option2, option3, option4);
				counter++;
				return question;
			} else {
				Question lastQuestion = new Question(0, "This is no question. Please calculate the score!", 0, null, null, null, null);
				return lastQuestion;
			}
		} catch (IOException | InterruptedException | ExecutionException e) {
			log.info("Inside showQuestion()====>Exception occurred===>" + e.getMessage());
		}
		return null;
	}

	@Override
	public void calculateScore(String questNo, int parseInt) {
		try {
			log.info("Inside calculateScore()===>Connected to Ethereum client version: "
					+ web3j.web3ClientVersion().send().getWeb3ClientVersion());
			NewOnlineTest onlineTest = NewOnlineTest.load(CONTRACT_ADDRESS, web3j, txManager, BigInteger.valueOf(10000),
					BigInteger.valueOf(4500000));
			Tuple3<BigInteger, String, BigInteger> questTuple = onlineTest.questions(BigInteger.valueOf(Integer.parseInt(questNo)-1))
					.sendAsync().get();
			if(parseInt == questTuple.getValue3().intValue()){
				//hardcoded the first user
				receipt = onlineTest.setScore(BigInteger.valueOf(0), true).sendAsync().get();
				log.info("Inside calculateScore()===>Tx Detail====>> "+receipt);
			}
		} catch (IOException | NumberFormatException | InterruptedException | ExecutionException e) {
			log.info("Inside calculateScore()====>Exception occurred===>" + e.getMessage());
		}
	}

	@Override
	public int getScore() {
		try {
			log.info("Inside getScore()===>Connected to Ethereum client version: "
					+ web3j.web3ClientVersion().send().getWeb3ClientVersion());
			NewOnlineTest onlineTest = NewOnlineTest.load(CONTRACT_ADDRESS, web3j, txManager, BigInteger.valueOf(10000),
					BigInteger.valueOf(4500000));
			//hardcoded the first user
			int theScore = onlineTest.getScore(BigInteger.valueOf(0)).sendAsync().get().intValue();
			log.info("Inside getScore()===>Score===>"+ theScore);
			return theScore;
		} catch (IOException | InterruptedException | ExecutionException e) {
			log.info("Inside getScore()====>Exception occurred===>" + e.getMessage());
		}
		return 0;
	}

}
