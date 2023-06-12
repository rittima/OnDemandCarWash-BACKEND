package CG.washer.GreenCarWash.service;

import CG.washer.GreenCarWash.exceptionHandlers.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;
}
