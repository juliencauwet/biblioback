package com.openclassrooms.endpoints;

import com.openclassrooms.biblioback.ws.*;
import com.openclassrooms.entities.AppUser;
import com.openclassrooms.services.AppUserService;
import com.openclassrooms.services.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AppUserEndPoint {
    private static final String NAMESPACE_URI = "http://appuser.ws.biblioback.openclassrooms.com";

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    public AppUserEndPoint(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    /**
     *
     * @param request
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "appUserAddRequest")
    @ResponsePayload
    public void addAppUser(@RequestPayload AppUserAddRequest request){
        AppUser appUser = new AppUser();
        appUser.setFirstName(request.getFirstName());
        appUser.setName(request.getName());
        appUser.setPassword(request.getPassword());
        appUser.setEmail(request.getEmail());
        appUserService.addUser(appUser);
    }
    /*
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addArticleRequest")
	@ResponsePayload
	public AddArticleResponse addArticle(@RequestPayload AddArticleRequest request) {
		AddArticleResponse response = new AddArticleResponse();
    	        ServiceStatus serviceStatus = new ServiceStatus();
		Article article = new Article();
		article.setTitle(request.getTitle());
		article.setCategory(request.getCategory());
                boolean flag = articleService.addArticle(article);
                if (flag == false) {
        	   serviceStatus.setStatusCode("CONFLICT");
        	   serviceStatus.setMessage("Content Already Available");
        	   response.setServiceStatus(serviceStatus);
                } else {
		   ArticleInfo articleInfo = new ArticleInfo();
	           BeanUtils.copyProperties(article, articleInfo);
		   response.setArticleInfo(articleInfo);
        	   serviceStatus.setStatusCode("SUCCESS");
        	   serviceStatus.setMessage("Content Added Successfully");
        	   response.setServiceStatus(serviceStatus);
                }
                return response;
	}
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "appUserValidityCheckRequest")
    @ResponsePayload
    public AppUserValidityCheckResponse checkUser(@RequestPayload AppUserValidityCheckRequest request){

       return null;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "appUserGetAllRequest")
    @ResponsePayload
    public AppUserGetAllResponse getAllAppUsers() {
        AppUserGetAllResponse response = new AppUserGetAllResponse();
        List<AppUser> appUsers = appUserService.getAllAppUsers();
        List<com.openclassrooms.biblioback.ws.AppUser> WSAppUsers = new ArrayList<>();

        for (int i = 0; i < appUsers.size(); i++){
            com.openclassrooms.biblioback.ws.AppUser appUser = new com.openclassrooms.biblioback.ws.AppUser();
            BeanUtils.copyProperties(appUsers.get(i),appUser);
            WSAppUsers.add(appUser);
        }

        response.getGetAllAppUsers().addAll(WSAppUsers);

        return response;
    }

     /*
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllArticlesRequest")
	@ResponsePayload
	public GetAllArticlesResponse getAllArticles() {
		GetAllArticlesResponse response = new GetAllArticlesResponse();
		List<ArticleInfo> articleInfoList = new ArrayList<>();
		List<Article> articleList = articleService.getAllArticles();
		for (int i = 0; i < articleList.size(); i++) {
		     ArticleInfo ob = new ArticleInfo();
		     BeanUtils.copyProperties(articleList.get(i), ob);
		     articleInfoList.add(ob);
		}
		response.getArticleInfo().addAll(articleInfoList);
		return response;
	}
     */
}

