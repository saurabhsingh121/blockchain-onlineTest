package com.saurabh.onlineTest.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class NewOnlineTest extends Contract {
    private static final String BINARY = "608060405260001960035560001960045534801561001c57600080fd5b5060008054600160a060020a03191633179055610e278061003e6000396000f3006080604052600436106100ae5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e1af57b81146100b35780631510841c146100dd57806331b1b9781461016d578063349ad5aa1461020b578063365b98b2146102e25780634d96276c146104455780637d7591f0146104a5578063c038450c146104ba578063df8bee86146104d7578063f0c37a59146105ef578063f851a44014610604575b600080fd5b3480156100bf57600080fd5b506100cb600435610642565b60408051918252519081900360200190f35b3480156100e957600080fd5b506100f860043560243561066f565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561013257818101518382015260200161011a565b50505050905090810190601f16801561015f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561017957600080fd5b50610185600435610734565b6040518084815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b838110156101ce5781810151838201526020016101b6565b50505050905090810190601f1680156101fb5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561021757600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526102e094369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506108049650505050505050565b005b3480156102ee57600080fd5b506102fa6004356108f5565b60405180806020018060200180602001858152602001848103845288818151815260200191508051906020019080838360005b8381101561034557818101518382015260200161032d565b50505050905090810190601f1680156103725780820380516001836020036101000a031916815260200191505b50848103835287518152875160209182019189019080838360005b838110156103a557818101518382015260200161038d565b50505050905090810190601f1680156103d25780820380516001836020036101000a031916815260200191505b50848103825286518152865160209182019188019080838360005b838110156104055781810151838201526020016103ed565b50505050905090810190601f1680156104325780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561045157600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526102e09583359536956044949193909101919081908401838280828437509497505093359450610adc9350505050565b3480156104b157600080fd5b506100cb610bb8565b3480156104c657600080fd5b506102e06004356024351515610bbe565b3480156104e357600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526102e095833595369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750610c189650505050505050565b3480156105fb57600080fd5b506100cb610cf3565b34801561061057600080fd5b50610619610cf9565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b60008060028381548110151561065457fe5b60009182526020909120600360049092020101549392505050565b6060600060018481548110151561068257fe5b600091825260208083208684526003600490930201918201815260409283902080548451601f6002600019610100600186161502019093169290920491820184900484028101840190955280855292945091908301828280156107265780601f106106fb57610100808354040283529160200191610726565b820191906000526020600020905b81548152906001019060200180831161070957829003601f168201915b505050505091505092915050565b600180548290811061074257fe5b9060005260206000209060040201600091509050806000015490806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107f45780601f106107c9576101008083540402835291602001916107f4565b820191906000526020600020905b8154815290600101906020018083116107d757829003601f168201915b5050505050908060020154905083565b61080c610d15565b60005473ffffffffffffffffffffffffffffffffffffffff16331461083057600080fd5b50604080516080810182528481526020808201859052918101839052600060608201819052600280546001810180835591909252825180519394919385936004027f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace01926108a2928492910190610d3e565b5060208281015180516108bb9260018501920190610d3e565b50604082015180516108d7916002840191602090910190610d3e565b50606091909101516003909101555050600480546001019055505050565b600280548290811061090357fe5b60009182526020918290206004919091020180546040805160026001841615610100026000190190931692909204601f81018590048502830185019091528082529193509183919083018282801561099c5780601f106109715761010080835404028352916020019161099c565b820191906000526020600020905b81548152906001019060200180831161097f57829003601f168201915b505050505090806001018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a3a5780601f10610a0f57610100808354040283529160200191610a3a565b820191906000526020600020905b815481529060010190602001808311610a1d57829003601f168201915b50505060028085018054604080516020601f6000196101006001871615020190941695909504928301859004850281018501909152818152959695945090925090830182828015610acc5780601f10610aa157610100808354040283529160200191610acc565b820191906000526020600020905b815481529060010190602001808311610aaf57829003601f168201915b5050505050908060030154905084565b610ae4610dbc565b60005473ffffffffffffffffffffffffffffffffffffffff163314610b0857600080fd5b506040805160608101825284815260208082018581529282018490526001805480820180835560009290925283517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6600490920291820190815594518051949592948694610b9a937fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf701920190610d3e565b50604091909101516002909101555050600380546001019055505050565b60035481565b6000805473ffffffffffffffffffffffffffffffffffffffff163314610be357600080fd5b6002805484908110610bf157fe5b906000526020600020906004020190508115610c135760038101805460010190555b505050565b6000805473ffffffffffffffffffffffffffffffffffffffff163314610c3d57600080fd5b6001805487908110610c4b57fe5b60009182526020808320600184526003600490930201918201815260409092208751919350610c7f92909190880190610d3e565b506002600090815260038201602090815260409091208551610ca392870190610d3e565b5060036000818152908201602090815260409091208451610cc692860190610d3e565b506004600090815260038201602090815260409091208351610cea92850190610d3e565b50505050505050565b60045481565b60005473ffffffffffffffffffffffffffffffffffffffff1681565b608060405190810160405280606081526020016060815260200160608152602001600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610d7f57805160ff1916838001178555610dac565b82800160010185558215610dac579182015b82811115610dac578251825591602001919060010190610d91565b50610db8929150610dde565b5090565b6060604051908101604052806000815260200160608152602001600081525090565b610df891905b80821115610db85760008155600101610de4565b905600a165627a7a72305820aec4829be1646b186b48c43af23a39997782f35596c333842e564146321deb0e0029";

    public static final String FUNC_GETSCORE = "getScore";

    public static final String FUNC_GETOPTIONLIST = "getOptionList";

    public static final String FUNC_QUESTIONS = "questions";

    public static final String FUNC_SETUSERPROFILE = "setUserProfile";

    public static final String FUNC_USERS = "users";

    public static final String FUNC_SETQUESTION = "setQuestion";

    public static final String FUNC_QUESTCOUNTER = "questCounter";

    public static final String FUNC_SETSCORE = "setScore";

    public static final String FUNC_SETOPTIONLIST = "setOptionList";

    public static final String FUNC_USERCOUNTER = "userCounter";

    public static final String FUNC_ADMIN = "admin";

    protected NewOnlineTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected NewOnlineTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> getScore(BigInteger index) {
        final Function function = new Function(FUNC_GETSCORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getOptionList(BigInteger index, BigInteger _optionNo) {
        final Function function = new Function(FUNC_GETOPTIONLIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.generated.Uint256(_optionNo)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple3<BigInteger, String, BigInteger>> questions(BigInteger param0) {
        final Function function = new Function(FUNC_QUESTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, String, BigInteger>>(
                new Callable<Tuple3<BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setUserProfile(String _userId, String _userName, String _testId) {
        final Function function = new Function(
                FUNC_SETUSERPROFILE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_userId), 
                new org.web3j.abi.datatypes.Utf8String(_userName), 
                new org.web3j.abi.datatypes.Utf8String(_testId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<String, String, String, BigInteger>> users(BigInteger param0) {
        final Function function = new Function(FUNC_USERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, String, String, BigInteger>>(
                new Callable<Tuple4<String, String, String, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setQuestion(BigInteger _questionNo, String _question, BigInteger _correctOption) {
        final Function function = new Function(
                FUNC_SETQUESTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_questionNo), 
                new org.web3j.abi.datatypes.Utf8String(_question), 
                new org.web3j.abi.datatypes.generated.Uint256(_correctOption)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> questCounter() {
        final Function function = new Function(FUNC_QUESTCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setScore(BigInteger index, Boolean result) {
        final Function function = new Function(
                FUNC_SETSCORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Bool(result)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setOptionList(BigInteger index, String option1, String option2, String option3, String option4) {
        final Function function = new Function(
                FUNC_SETOPTIONLIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Utf8String(option1), 
                new org.web3j.abi.datatypes.Utf8String(option2), 
                new org.web3j.abi.datatypes.Utf8String(option3), 
                new org.web3j.abi.datatypes.Utf8String(option4)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> userCounter() {
        final Function function = new Function(FUNC_USERCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> admin() {
        final Function function = new Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<NewOnlineTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(NewOnlineTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<NewOnlineTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(NewOnlineTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static NewOnlineTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewOnlineTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static NewOnlineTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new NewOnlineTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
