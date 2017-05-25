package com.github.izaquias.divulgueaquiweb.model;

import com.github.izaquias.divulgueaquiweb.model.Usuario;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-25T00:03:54")
@StaticMetamodel(Problema.class)
public class Problema_ { 

    public static volatile SingularAttribute<Problema, LocalDate> data;
    public static volatile SingularAttribute<Problema, String> localidade;
    public static volatile SingularAttribute<Problema, String> categoria;
    public static volatile SingularAttribute<Problema, Long> id;
    public static volatile ListAttribute<Problema, Usuario> usuarios;
    public static volatile SingularAttribute<Problema, String> descricao;

}