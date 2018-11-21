package Projetouniandrade.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projetouniandrade.domain.Categoria;
import Projetouniandrade.domain.Cidade;
import Projetouniandrade.domain.Cliente;
import Projetouniandrade.domain.Endereco;
import Projetouniandrade.domain.Estado;
import Projetouniandrade.domain.ItemPedido;
import Projetouniandrade.domain.Pagamento;
import Projetouniandrade.domain.PagamentoComBoleto;
import Projetouniandrade.domain.PagamentoComCartao;
import Projetouniandrade.domain.Pedido;
import Projetouniandrade.domain.Produto;
import Projetouniandrade.domain.enums.EstadoPagamento;
import Projetouniandrade.domain.enums.TipoCliente;
import Projetouniandrade.repositories.CategoriaRepository;
import Projetouniandrade.repositories.CidadeRepository;
import Projetouniandrade.repositories.ClienteRepository;
import Projetouniandrade.repositories.EnderecoRepository;
import Projetouniandrade.repositories.EstadoRepository;
import Projetouniandrade.repositories.ItemPedidoRepository;
import Projetouniandrade.repositories.PagamentoRepository;
import Projetouniandrade.repositories.PedidoRepository;
import Projetouniandrade.repositories.ProdutoRepository;

@Service
public class DBService {
	
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
 	private PagamentoRepository pagamentoRepository;
 	@Autowired
 	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
				
			Categoria cat3 = new Categoria(null, "Eletrônicos");
			Categoria cat6 = new Categoria(null, "Eletrodomésticos");
			Categoria cat1 = new Categoria(null, "Pequeno Porte");
			Categoria cat4 = new Categoria(null, "Metais");
			Categoria cat5 = new Categoria(null, "portateis");
			Categoria cat2 = new Categoria(null, "Pesado");
			
			Produto p1 = new Produto(null, "Computador", 100.00);
			Produto p2 = new Produto(null, "Notebook", 70.00);
			Produto p3 = new Produto(null, "Celular", 50.00);
			Produto p4 = new Produto(null, "Placa Mãe", 50.00);
			Produto p5 = new Produto(null, "Televisor", 50.00);
			Produto p6 = new Produto(null, "Monitor", 50.00);
			Produto p7 = new Produto(null, "Microondas", 50.00);
			Produto p8 = new Produto(null, "Placas diversas", 800.00);
			Produto p9 = new Produto(null, "Fonte", 100.00);
			Produto p10 = new Produto(null, "Plastico", 180.00);
			Produto p11 = new Produto(null, "Periféricos", 90.00);
			
			
			
			cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
			cat2.getProdutos().addAll(Arrays.asList(p4));
			cat3.getProdutos().addAll(Arrays.asList(p5, p6));
			cat4.getProdutos().addAll(Arrays.asList(p7));
			cat5.getProdutos().addAll(Arrays.asList(p8, p9));
			cat6.getProdutos().addAll(Arrays.asList(p10, p11));
			
			
			
			p1.getCategorias().addAll(Arrays.asList(cat1));
			p2.getCategorias().addAll(Arrays.asList(cat1));
			p3.getCategorias().addAll(Arrays.asList(cat1));
			p4.getCategorias().addAll(Arrays.asList(cat2));
			p5.getCategorias().addAll(Arrays.asList(cat3));
			p6.getCategorias().addAll(Arrays.asList(cat3));
			p7.getCategorias().addAll(Arrays.asList(cat4));
			p8.getCategorias().addAll(Arrays.asList(cat5));
			p9.getCategorias().addAll(Arrays.asList(cat5));
			p10.getCategorias().addAll(Arrays.asList(cat6));
			p11.getCategorias().addAll(Arrays.asList(cat6));
			
			categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
			produtoRepository.saveAll(Arrays.asList(p1, p2, p3,p4, p5, p6, p7, p8, p9, p10, p11));
		
			Estado est1 = new Estado(null, "Curitiba");
	 		Estado est2 = new Estado(null, "São Paulo");
	 		
	 		Cidade c1 = new Cidade(null, "Curitiba", est1);
	 		Cidade c2 = new Cidade(null, "São Paulo", est2);
	 		Cidade c3 = new Cidade(null, "Campinas", est2);
	 		
	 		est1.getCidades().addAll(Arrays.asList(c1));
	 		est2.getCidades().addAll(Arrays.asList(c2, c3));
	 		estadoRepository.saveAll(Arrays.asList(est1, est2));
			cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
			Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
			
			cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
			
			Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
			Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
			
			cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
			
			clienteRepository.saveAll(Arrays.asList(cli1));
			enderecoRepository.saveAll(Arrays.asList(e1, e2));
			
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	 		
	 		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
	 		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
	 		
	 		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
	 		ped1.setPagamento(pagto1);
	 		
	 		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
	 		ped2.setPagamento(pagto2);
	 		
	 		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
	 				
	 		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
	 		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));	
			
		
			ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 100.00);
			ItemPedido ip2 = new ItemPedido(ped1, p5, 0.00, 1, 50.00);
			ItemPedido ip3 = new ItemPedido(ped2, p2, 20.00, 1, 70.00);
		
			ped1.getItens().addAll(Arrays.asList(ip1, ip2));
			ped2.getItens().addAll(Arrays.asList(ip3));
		
			p1.getItens().addAll(Arrays.asList(ip1));
			p5.getItens().addAll(Arrays.asList(ip2));
			p2.getItens().addAll(Arrays.asList(ip3));
			
			itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));	
	}
}
	