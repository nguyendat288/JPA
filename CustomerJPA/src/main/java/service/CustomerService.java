package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.IRepositoryCustomer;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    @Autowired
    IRepositoryCustomer iRepositoryCustomer;

    @Override
    public Customer save(Customer customer) {
        return iRepositoryCustomer.save(customer);
    }
    @Override
    public Customer findById(int id){
        return iRepositoryCustomer.findById(id).get();
    }

    @Override
    public ArrayList<Customer> findAll() {
        return (ArrayList<Customer> )iRepositoryCustomer.findAll();
    }

    @Override
    public ArrayList<Customer> findAllByName(String name) {
        return iRepositoryCustomer.findCustomerByName(name);
    }
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iRepositoryCustomer.findAll(pageable);
    }

    @Override
    public void delete(Customer customer) {
        iRepositoryCustomer.delete(customer);
    }

    @Override
    public void edit(Customer customer) {
        iRepositoryCustomer.save(customer);
    }


}
