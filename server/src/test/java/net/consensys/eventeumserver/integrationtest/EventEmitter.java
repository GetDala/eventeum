package net.consensys.eventeumserver.integrationtest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class EventEmitter extends Contract {
    private static final String BINARY = "606060405234610000575b610195806100196000396000f300606060405263ffffffff60e060020a600035041663eb792e7d811461002f578063f6af6ace14610051575b610000565b346100005761004f60048035906024803591604435918201910135610073565b005b346100005761004f600480359060248035916044359182019101356100ee565b005b3373ffffffffffffffffffffffffffffffffffffffff1684600019167f8593d2962dfa1d5d1c37a74943611d407b6f5ccc638f83e450b6b7c9f81f3a9e858585604051808481526020018060200182810382528484828181526020019250808284376040519201829003965090945050505050a35b50505050565b3373ffffffffffffffffffffffffffffffffffffffff1684600019167f46aca551d5bafd01d98f8cadeb9b50f1b3ee44c33007f2a13d969dab7e7cf2a8858585604051808481526020018060200182810382528484828181526020019250808284376040519201829003965090945050505050a35b505050505600a165627a7a72305820b31cf576c266c029877dade818bdb696812b7967756b88faca40ab77ebd9b7550029";

    public static final String FUNC_EMITNOTORDERED = "emitNotOrdered";

    public static final String FUNC_EMIT = "emit";

    public static final Event DUMMYEVENT_EVENT = new Event("DummyEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event DUMMYEVENTNOTORDERED_EVENT = new Event("DummyEventNotOrdered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    protected EventEmitter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EventEmitter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> emitNotOrdered(byte[] value1, BigInteger value2, String value3) {
        final Function function = new Function(
                FUNC_EMITNOTORDERED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(value1), 
                new org.web3j.abi.datatypes.generated.Uint256(value2), 
                new org.web3j.abi.datatypes.Utf8String(value3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> emit(byte[] value1, BigInteger value2, String value3) {
        final Function function = new Function(
                FUNC_EMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(value1), 
                new org.web3j.abi.datatypes.generated.Uint256(value2), 
                new org.web3j.abi.datatypes.Utf8String(value3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<DummyEventEventResponse> getDummyEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DUMMYEVENT_EVENT, transactionReceipt);
        ArrayList<DummyEventEventResponse> responses = new ArrayList<DummyEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DummyEventEventResponse typedResponse = new DummyEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.indexedBytes = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.indexedAddress = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.uintValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.stringValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DummyEventEventResponse> dummyEventEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DummyEventEventResponse>() {
            @Override
            public DummyEventEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DUMMYEVENT_EVENT, log);
                DummyEventEventResponse typedResponse = new DummyEventEventResponse();
                typedResponse.log = log;
                typedResponse.indexedBytes = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.indexedAddress = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.uintValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.stringValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DummyEventEventResponse> dummyEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DUMMYEVENT_EVENT));
        return dummyEventEventObservable(filter);
    }

    public List<DummyEventNotOrderedEventResponse> getDummyEventNotOrderedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DUMMYEVENTNOTORDERED_EVENT, transactionReceipt);
        ArrayList<DummyEventNotOrderedEventResponse> responses = new ArrayList<DummyEventNotOrderedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DummyEventNotOrderedEventResponse typedResponse = new DummyEventNotOrderedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.indexedBytes = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.indexedAddress = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.uintValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.stringValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DummyEventNotOrderedEventResponse> dummyEventNotOrderedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DummyEventNotOrderedEventResponse>() {
            @Override
            public DummyEventNotOrderedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DUMMYEVENTNOTORDERED_EVENT, log);
                DummyEventNotOrderedEventResponse typedResponse = new DummyEventNotOrderedEventResponse();
                typedResponse.log = log;
                typedResponse.indexedBytes = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.indexedAddress = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.uintValue = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.stringValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DummyEventNotOrderedEventResponse> dummyEventNotOrderedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DUMMYEVENTNOTORDERED_EVENT));
        return dummyEventNotOrderedEventObservable(filter);
    }

    public static RemoteCall<EventEmitter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EventEmitter.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EventEmitter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EventEmitter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static EventEmitter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventEmitter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EventEmitter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventEmitter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class DummyEventEventResponse {
        public Log log;

        public byte[] indexedBytes;

        public String indexedAddress;

        public BigInteger uintValue;

        public String stringValue;
    }

    public static class DummyEventNotOrderedEventResponse {
        public Log log;

        public byte[] indexedBytes;

        public String indexedAddress;

        public BigInteger uintValue;

        public String stringValue;
    }
}
