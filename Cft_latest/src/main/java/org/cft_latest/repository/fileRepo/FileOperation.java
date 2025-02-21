package org.cft_latest.repository.fileRepo;

public interface FileOperation<I,A> {
    void operate(I input ,A applicationFile);
}
