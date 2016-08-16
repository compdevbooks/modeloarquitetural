package br.com.compdevbooks.business;

import br.com.compdevbooks.dao.IDAO;
import br.com.compdevbooks.entity.FooEntity;
import br.com.compdevbooks.entity.IEntity;

public class FooBusiness extends ABusiness {

    public FooBusiness(IDAO dao) {
        super(dao);
    }

    @Override
    public Exception validate(IEntity iEntity) {
        FooEntity fooEntity = (FooEntity) iEntity;
        if (fooEntity.getFooString()==null || fooEntity.getFooString().trim().length()==0)
            return new Exception("fooString is required, it can not be empty!");
        return null;
    }
}
