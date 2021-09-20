package the.biagi.DesafioMagaLab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import the.biagi.DesafioMagaLab.repositories.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String emailUsuario) throws UsernameNotFoundException {
        return  usuarioRepository.findByEmailUsuario(emailUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
