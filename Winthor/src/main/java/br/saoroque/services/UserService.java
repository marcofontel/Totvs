package br.saoroque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.saoroque.controller.payloads.LoginPayload;
import br.saoroque.controller.payloads.UsuarioPayload;
import br.saoroque.jwt.JwtTokenProvider;
import br.saoroque.jwt.Role;
import br.saoroque.jwt.UserPrincipal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private String getUsuarioQueryBySenha() {
        return "select DISTINCT matricula, nome, nome_guerra, email " +
                "from pcempr where NOME_GUERRA = :usuario AND decrypt(senhabd, NOME_GUERRA) = :senha";
    }

    private String getUsuarioQueryById() {
        return "select DISTINCT matricula, nome, nome_guerra, email " +
                "from pcempr where matricula = :matricula ";
    }

    public Object[] getMatriculaUsuario(LoginPayload loginPayload) {
        try {
            Query nativeQuery = entityManager.createNativeQuery(getUsuarioQueryBySenha());
            nativeQuery.setParameter("usuario", loginPayload.getUsuario());
            nativeQuery.setParameter("senha", loginPayload.getSenha());

            Object[] result = (Object[]) nativeQuery.getSingleResult();

            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    public String getToken(LoginPayload loginPayload) {
        Object[] usuarioPC = getMatriculaUsuario(loginPayload);
        if (usuarioPC != null) {
            BigDecimal matricula = (BigDecimal) usuarioPC[0];
            UsuarioPayload usuario = new UsuarioPayload(matricula.longValue(), (String) usuarioPC[1], (String) usuarioPC[2], (String) usuarioPC[3], true);
            return jwtTokenProvider.generateToken(usuario);
        }
        throw new IllegalArgumentException("Usuário ou senha incorretos");
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserById(Long id) {
        try {
            Query nativeQuery = entityManager.createNativeQuery(getUsuarioQueryById());
            nativeQuery.setParameter("matricula", id);

            Object[] usuarioPC = (Object[]) nativeQuery.getSingleResult();

            if (usuarioPC != null) {
                BigDecimal matricula = (BigDecimal) usuarioPC[0];
                ;
                UserPrincipal usuario = new UserPrincipal(matricula.longValue(), (String) usuarioPC[1], (String) usuarioPC[2], (String) usuarioPC[3], null, Arrays.asList(Role.values()));
                return usuario;
            }
        } catch (NoResultException e) {
            return null;
        }
        return null;
    }
}
