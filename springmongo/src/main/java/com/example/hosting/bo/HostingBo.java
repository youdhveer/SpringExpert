package com.example.hosting.bo;

import com.example.seq.exception.SequenceException;

public interface HostingBo {

	void save(String name) throws SequenceException;

}