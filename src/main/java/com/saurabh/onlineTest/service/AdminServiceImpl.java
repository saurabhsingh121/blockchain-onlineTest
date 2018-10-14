package com.saurabh.onlineTest.service;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.parity.Parity;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.ClientTransactionManager;

import com.saurabh.onlineTest.contract.NewOnlineTest;
import com.saurabh.onlineTest.entity.Question;
import com.saurabh.onlineTest.entity.User;

@Service
public class AdminServiceImpl implements AdminService {

	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	private static final String ADDRESS = "0xe8fbbddf73c128e25f824ec6af15cb15c237fe58";
	// considering that smart contract is already deployed
	private static final String CONTRACT_ADDRESS = "0x96CE6376d15A911F58A68aF459F061570464b141";
	private Parity web3j = Parity.build(new HttpService());
	// considering that admin account is unlocked forever
	private ClientTransactionManager txManager = new ClientTransactionManager(web3j, ADDRESS);
	private List<User> userList = null;
	private TransactionReceipt receipt = null;
	@Override
	public List<User> getUserList() {
		userList = new ArrayList<>();
		try {
			log.info("Inside getUserList()===>Connected to Ethereum client version: "
					+ web3j.web3ClientVersion().send().getWeb3ClientVersion());

			NewOnlineTest onlineTest = NewOnlineTest.load(CONTRACT_ADDRESS, web3j, txManager, BigInteger.valueOf(10000),
					BigInteger.valueOf(4500000));

			int userCounter = onlineTest.userCounter().sendAsync().get().intValue();

			for (int i = 0; i <= userCounter; i++) {
				Tuple4<String, String, String, BigInteger> userTuple = onlineTest.users(BigInteger.valueOf(i))
						.sendAsync().get();
				User theUser = new User(userTuple.getValue1(), userTuple.getValue2(), userTuple.getValue3(),
						userTuple.getValue4().intValue());
				userList.add(theUser);
			}
			return userList;
		} catch (IOException | InterruptedException | ExecutionException e) {
			log.info("Inside getUserList()====>Exception occurred===>" + e.getMessage());
		}
		return null;
	}

	@Override
	public void addQuestion(Question newQuestion) {
		try {
			log.info("Inside addQuestion()===>Connected to Ethereum client version: "
					+ web3j.web3ClientVersion().send().getWeb3ClientVersion());
			NewOnlineTest onlineTest = NewOnlineTest.load(CONTRACT_ADDRESS, web3j, txManager, BigInteger.valueOf(10000),
					BigInteger.valueOf(4500000));

			receipt = onlineTest.setQuestion(BigInteger.valueOf(newQuestion.getQuestionNo()),
					newQuestion.getQuestion(), BigInteger.valueOf(newQuestion.getCorrectOption())).sendAsync().get();
			log.info("Inside addQuestion()===>Tx Detail====>> "+receipt);
			int questCounter = onlineTest.questCounter().sendAsync().get().intValue();
			receipt = onlineTest.setOptionList(BigInteger.valueOf(questCounter), newQuestion.getOption1(), newQuestion.getOption2(),
					newQuestion.getOption3(), newQuestion.getOption4()).sendAsync().get();
			log.info("Inside addQuestion()===>Tx Detail====>> "+receipt);
		} catch (IOException | InterruptedException | ExecutionException e) {
			log.info("Inside addQuestion()====>Exception occurred===>" + e.getMessage());
		}

	}

	@Override
	public void addUser(User theUser) {
		try {
			log.info("Inside addQuestion()===>Connected to Ethereum client version: "
					+ web3j.web3ClientVersion().send().getWeb3ClientVersion());
			NewOnlineTest onlineTest = NewOnlineTest.load(CONTRACT_ADDRESS, web3j, txManager, BigInteger.valueOf(10000),
					BigInteger.valueOf(4500000));
			receipt = onlineTest.setUserProfile(theUser.getUserId(), theUser.getUserName(), theUser.getTestId()).sendAsync().get();
			int userCounter = onlineTest.userCounter().sendAsync().get().intValue();
			FileWriter fw = new FileWriter("out.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(theUser.getUserId()+"_"+String.valueOf(userCounter));
			bw.newLine();
			bw.close();
		} catch (IOException | InterruptedException | ExecutionException e) {
			log.info("Inside addQuestion()====>Exception occurred===>" + e.getMessage());
		}
		
	}

}
