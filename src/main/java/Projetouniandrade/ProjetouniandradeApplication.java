package Projetouniandrade;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Projetouniandrade.domain.Categoria;
import Projetouniandrade.domain.Cidade;
import Projetouniandrade.domain.Cliente;
import Projetouniandrade.domain.Endereco;
import Projetouniandrade.domain.Estado;
import Projetouniandrade.domain.Pedido;
import Projetouniandrade.domain.Produto;
import Projetouniandrade.domain.Residuo;
import Projetouniandrade.domain.enums.StatusResiduo;
import Projetouniandrade.domain.enums.TipoCliente;
import Projetouniandrade.repositories.CategoriaRepository;
import Projetouniandrade.repositories.CidadeRepository;
import Projetouniandrade.repositories.ClienteRepository;
import Projetouniandrade.repositories.EnderecoRepository;
import Projetouniandrade.repositories.EstadoRepository;
import Projetouniandrade.repositories.PedidoRepository;
import Projetouniandrade.repositories.ProdutoRepository;
import Projetouniandrade.repositories.ResiduoRepository;

@SpringBootApplication
public class ProjetouniandradeApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ResiduoRepository residuoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetouniandradeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Eletrodomésticos");
		Categoria cat3 = new Categoria(null, "Pequeno Porte");
		
		Produto p1 = new Produto(null, "Computador", 100.00);
		Produto p2 = new Produto(null, "Notebook", 70.00);
		Produto p3 = new Produto(null, "Celular", 50.00);
		Produto p4 = new Produto(null, "Placa Mãe", 50.00);
		Produto p5 = new Produto(null, "Televisor", 50.00);
		Produto p6 = new Produto(null, "Monitor", 50.00);
		Produto p7 = new Produto(null, "Microondas", 50.00);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3, p4));
		cat2.getProdutos().addAll(Arrays.asList(p7));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat2));
		p6.getCategorias().addAll(Arrays.asList(cat2));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3,p4, p5, p6, p7));
	
		Estado est1 = new Estado(null, "Paraná");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Curitiba", est1);
		Cidade c2 = new Cidade(null, "São José dos Pinhais", est1);
		Cidade c3 = new Cidade(null, "Araucária", est1);
		Cidade c4 = new Cidade(null, "Colombo", est1);
		Cidade c5 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2, c3, c4));
		est2.getCidades().addAll(Arrays.asList(c5));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	
		Cliente cli1 = new  Cliente(null, "Joao", "joaont@gmail.com", "88293188300", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("12121212", "23333355555"));
		
		Endereco e1 = new Endereco(null, "Rua frei miguel", "666", "casa", "centro", "182292928", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua padre antonio", "999", "casa", "centro", "182543928", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
	
		clienteRepository.saveAll(Arrays.asList(cli1));	
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2018 17:54"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("01/10/2018 10:03"), cli1, e2);
	
		Residuo res1 = new Residuo(null, StatusResiduo.STATUSAPROV, ped1);
		ped1.setResiduo(res1);
		
		Residuo res2 = new Residuo(null, StatusResiduo.STATUSDESAPROV, ped2);
		ped2.setResiduo(res2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		residuoRepository.saveAll(Arrays.asList(res1, res2));
	
	}
	
	
}
